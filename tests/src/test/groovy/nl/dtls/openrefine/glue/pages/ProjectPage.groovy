package nl.dtls.openrefine.glue.pages

import geb.Module
import geb.Page

class ProjectPage extends Page {
    static url = "/project"
    
    static at = {
        waitFor { $("div", class: "data-table-container") }
    }
    
    static content = {
        extensions { module ExtensionsBar }
    }
}

class ExtensionsBar extends Module {
    static content = {
        rdf { $("div", id: "extension-bar").$("a").has("span", text: "RDF") }
        
        rdfMenu(wait: true) { module RdfExtensionMenu }
    }
}

class RdfExtensionMenu extends Module {
    static base = { $("div", class: "menu-container") }
    
    static content = {
        edit(to: RdfExtensionPage, toWait: true) { $("a", class: "menu-item", text: "Edit RDF Skeleton...") }
    }
}
