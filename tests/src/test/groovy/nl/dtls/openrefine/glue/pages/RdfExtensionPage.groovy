package nl.dtls.openrefine.glue.pages

import geb.Module
import geb.Page

class RdfExtensionPage extends Page {
    static at = {
        waitFor {
            $("div", class: "dialog-busy").displayed == false
            $("div", class: "dialog-header", text: "RDF Schema Alignment")
        }
    }
    
    static content = {
        skeleton { module SkeletonTab }
        
        preview { module PreviewTab }
    }
}

class SkeletonTab extends Module {
    static content = {
        prefixes(wait: true) { $("div", class: "rdf-schema-prefixes") }
        
        addPrefixBtn(to: NewPrefixDialog, toWait: true) {
            $("div", id: "rdf-schema-alignment-tabs-schema").$("a", class: "add-prefix-box")
        }
        
        managePrefixesBtn(wait: true) {
            $("div", id: "rdf-schema-alignment-tabs-schema").$("a", class: "manage-vocabularies-box")
        }
    }
}

class PreviewTab extends Module {
    static base = { $("div", id: "rdf-schema-alignment-tabs-preview") }
    
    static content = {
        content { $("div", id: "rdf-schema-alignment-dialog-preview").$("pre") }
    }
}
