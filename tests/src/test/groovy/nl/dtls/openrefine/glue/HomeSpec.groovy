package nl.dtls.openrefine.glue

import org.openqa.selenium.interactions.Actions

import geb.spock.GebReportingSpec
import nl.dtls.openrefine.glue.pages.HomePage
import nl.dtls.openrefine.glue.pages.ProjectPage

class HomeSpec extends BaseOpenRefineSpec {
    def "Create a new project using the clipboard"() {
        given:
        to HomePage
        actions.createProject.click()
        
        when: "the clipboard option is opened"
        createOptions.clipboard.click()
        
        and: "dummy data is pasted into the textarea"
        form.clipboard = "a,b\n1,2"
        
        and: "the next button is clicked"
        nextBtn.click()
        
        and: "at the parsing properties page, the create button is clicked"
        createBtn.click()
        
        then: "the parsing options page is shown"
        at ProjectPage
    }
    
    def "Open existing project"() {
        given:
        to HomePage
        
        when: "the list of projects is openened"
        actions.openProject.click()
        
        and: "the first project in the list is clicked"
        openProject.projects[0].nameBtn.click()
        
        then:
        at ProjectPage
    }
}
