package model;

import model.util.JsfUtil;
import model.util.PaginationHelper;
import controller.VehicleOfInterestFacade;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("vehicleOfInterestController")
@SessionScoped
public class VehicleOfInterestController implements Serializable {
    private String searchString;
    private VehicleOfInterest current;
    private DataModel items = null;
    @EJB
    private controller.VehicleOfInterestFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public VehicleOfInterestController() {
    }

    public VehicleOfInterest getSelected() {
        if (current == null) {
            current = new VehicleOfInterest();
            selectedItemIndex = -1;
        }
        return current;
    }

    private VehicleOfInterestFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(100) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    int firstItem = getPageFirstItem();
                    int pageSize = getPageSize();
                    List<VehicleOfInterest> listRecords = getFacade().findRange(new int[]{firstItem, firstItem + pageSize});
            
                    if(searchString != null && !searchString.trim().isEmpty()) {
                        Iterator<VehicleOfInterest> itr = listRecords.iterator();

                        while (itr.hasNext()) {
                            if(!JsfUtil.containsIgnoreCase(itr.next().getLicensePlate(), searchString)) {
                                itr.remove(); 
                            } 
                        }
                    }
                    return new ListDataModel(listRecords);
                }
            };
        }
        return pagination;
    }
    
    public String searchByLicensePlate() {
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (VehicleOfInterest) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new VehicleOfInterest();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("VehicleOfInterestCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (VehicleOfInterest) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("VehicleOfInterestUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (VehicleOfInterest) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("VehicleOfInterestDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();           
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public VehicleOfInterest getVehicleOfInterest(java.lang.String id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = VehicleOfInterest.class)
    public static class VehicleOfInterestControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VehicleOfInterestController controller = (VehicleOfInterestController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "vehicleOfInterestController");
            return controller.getVehicleOfInterest(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof VehicleOfInterest) {
                VehicleOfInterest o = (VehicleOfInterest) object;
                return getStringKey(o.getLicensePlate());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + VehicleOfInterest.class.getName());
            }
        }

    }

}
