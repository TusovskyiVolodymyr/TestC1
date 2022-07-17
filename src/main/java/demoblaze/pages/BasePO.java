package demoblaze.pages;


import demoblaze.driver.DriverController;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePO {

    @Autowired
    protected DriverController controller;
}
