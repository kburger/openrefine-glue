package nl.dtls.openrefine.glue

import org.openqa.selenium.interactions.Actions

import geb.spock.GebReportingSpec
import nl.dtls.openrefine.glue.pages.HomePage

abstract class BaseOpenRefineSpec extends GebReportingSpec {
    // cleanup ran at the end of every test class
    def cleanupSpec() {
        // given we're at the homepage
        to HomePage
        
        // the open projects view is opened
        actions.openProject.click()
        
        // reverse the list of projects, and for each project
        openProject.projects.reverse().every { listing ->
            // hover mouse over the project row
            new Actions(driver).moveToElement(listing.firstElement()).perform()
            
            // click the delete button, and confirm the dialog that pops up
            withConfirm(true) { listing.deleteBtn.click() }
        }
    }
}
