package nl.dtls.openrefine.glue

import nl.dtls.openrefine.glue.pages.HomePage
import nl.dtls.openrefine.glue.pages.ProjectPage
import spock.lang.Shared

class RdfExtensionSpec extends BaseOpenRefineSpec {
    @Shared def projectId
    
    def setupSpec() {
        to HomePage
        createOptions.clipboard.click()
        form.clipboard = "a,b\n1,2"
        nextBtn.click()
        createBtn.click()
        
        // return the created project id
        projectId =  currentUrl.tokenize("?")[-1]
    }
    
    def setup() {
        to ProjectPage, project: projectId
    }
    
    def "test for opening and interacting with the rdf extension"() {
        given: "the rdf extension dialog is opened"
        extensions.rdf.click()
        extensions.rdfMenu.edit.click()
        
        when: "the add prefix dialog is opened"
        skeleton.addPrefixBtn.click()
        
        and: "the dcterms vocabulary is added"
        prefix.value("dcterms")
        uri.click() // focus the field so the namespace is automatically added
        okBtn.click()
        
        then: "the prefix is added to the list"
        skeleton.prefixes.has("span", text: "dcterms")
    }
}
