package nl.dtls.openrefine.glue.pages

import geb.Module
import geb.Page

class HomePage extends Page {
    static url = "/"
    
    static at = { title == "OpenRefine" }
    
    static content = {
        actions { $("ul", id: "action-area-tabs").module(ActionsModule) }
        
        openProject { $("div", id: "projects-container").module(OpenModule) }
        
        // TODO abstract this into a module?
        createOptions { $("td", id: "create-project-ui-source-selection-tabs").module(CreateOptionsModule) }
        form { $(".create-project-ui-source-selection-tab-body.selected form") }
        nextBtn(to: ParsingOptionsPage, toWait: true) { $(".create-project-ui-source-selection-tab-body.selected form button") }
    }
}

class ActionsModule extends Module {
    static content = {
        createProject { $("li", class: "action-area-tab", text: "Create Project") }
        
        openProject { $("li", class: "action-area-tab", text: "Open Project") }
        
        importProject { $("li", class: "action-area-tab", text: "Import Project") }
        
        languageSettings { $("li", class: "action-area-tab", text: "Language Settings") }
    }
}

class CreateOptionsModule extends Module {
    static content = { 
        thisComputer { $("div", class: "create-project-ui-source-selection-tab", text: "This Computer") }
        
        webAddress { $("div", class: "create-project-ui-source-selection-tab", text: "Web Addresses (URLS)") }
        
        clipboard { $("div", class: "create-project-ui-source-selection-tab", text: "Clipboard") }
        
        googleData { $("div", class: "create-project-ui-source-selection-tab", text: "Google Data") }
    }
}

class OpenModule extends Module {
    static content = {
        projects { $("table", class: "list-table").$("tr", class: "project").moduleList(ProjectListingModule) }
    }
}

class ProjectListingModule extends Module {
    static content = {
        deleteBtn { $("a", class: "delete-project") }
        
        renameBtn { $("a", text: "rename") }
        
        nameBtn { $("a", class: "project-name") }
    }
}
