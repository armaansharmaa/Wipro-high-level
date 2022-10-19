import React from "react";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Dashboard from "./pages/Dashboard";
import NotFound from "./pages/NotFound";
import UserComponent from "./components/UserComponent";
import UploadFiles from "./components/uploadFilesComponent";

function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Dashboard}/>
                <Route path="/Dashboard" exact component={Dashboard}/>
                <Route path="/Create" exact component={UploadFiles}/>
                <Route path="/View" exact component={UserComponent}/>
                <Route component={NotFound}/>
            </Switch>
        </BrowserRouter>
    )
}
export default Routes;