package nl.dtls.openrefine.glue.pages

import geb.Page

class NewPrefixDialog extends Page {
    static at = {
        waitFor { $("div", class:"dialog-frame").has("div", class: "dialog-header", text: "New Prefix") }
    }
    
    static content = {
        // basic fields
        prefix { $("input", type: "text", bind: "prefix") }
        
        uri { $("input", type: "text", bind: "uri") }
        
        // buttons
        okBtn(to: RdfExtensionPage, toWait: true) {
            $("div", class: "dialog-frame").has("div", class: "dialog-header", text: "New Prefix").$("button", text: "  OK  ")
        }
        
        cancelBtn(to: RdfExtensionPage, toWait: true) { $("button", text: "Cancel") }
        
        advancedBtn { $("button", id: "advanced_options_button") }
    }
}
