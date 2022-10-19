import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faHome,
  faBriefcase,
  faPaperPlane,
  faQuestion,
  faImage,
  faCopy,
  faTimes
} from "@fortawesome/free-solid-svg-icons";
import SubMenu from "./SubMenu";
import { Nav, Button } from "react-bootstrap";
import classNames from "classnames";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

class SideBar extends React.Component {
  render() {
    return (

      <div className={classNames("sidebar", { "is-open": this.props.isOpen })}>
        <div className="sidebar-header">
          <Button
            variant="link"
            onClick={this.props.toggle}
            style={{ color: "#fff" }}
            className="mt-4"
          >
            <FontAwesomeIcon icon={faTimes} pull="right" size="xs" />
          </Button>
          <h3>Interim Application</h3>
        </div>

        <Nav className="flex-column pt-2">
          <p className="ml-3">Person</p>

          <Nav.Item className="active">
            <Nav.Link title="Dashboard" href="/Dashboard">
              <FontAwesomeIcon icon={faHome} title="Dashboard" className="mr-2" />
              Dashboard
            </Nav.Link>
          </Nav.Item>
{/* <Nav.Item className="active">
            <Nav.Link title="Create" href="/Create">
              <FontAwesomeIcon icon={faHome} title="Create" className="mr-2" />
              Create
            </Nav.Link>
          </Nav.Item>
          <Nav.Item className="active">
                      <Nav.Link title="View" href="/View">
                        <FontAwesomeIcon icon={faHome} title="View" className="mr-2" />
                        View
                      </Nav.Link>
                    </Nav.Item>
                    <Nav.Item className="active">
                                <Nav.Link title="Update" href="/Update">
                                  <FontAwesomeIcon icon={faHome} title="Update" className="mr-2" />
                                  Update
                                </Nav.Link>
                              </Nav.Item> */}
          <SubMenu
            title="Person"
            icon={faCopy}
            items={["Create", "View" ,"Search" ]}
          />

          <Nav.Item>
            <Nav.Link href="/">
              <FontAwesomeIcon icon={faBriefcase} className="mr-2" />
              About
            </Nav.Link>
          </Nav.Item>

          <Nav.Item>
            <Nav.Link href="/Contact">
              <FontAwesomeIcon icon={faPaperPlane} className="mr-2" />
              Contact
            </Nav.Link>
          </Nav.Item>
        </Nav>
      </div>

    );
  }
}

export default SideBar;
