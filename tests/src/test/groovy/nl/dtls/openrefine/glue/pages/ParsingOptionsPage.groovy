package nl.dtls.openrefine.glue.pages

import geb.Page

class ParsingOptionsPage extends Page {
    static at = {
        waitFor { $("table", class: "data-table") }
    }
    
    static content = {
        createBtn(to: ProjectPage, toWait: true) {
            $("div", class: "default-importing-wizard-header").$("button", bind: "nextButton")
        }
    }
}
