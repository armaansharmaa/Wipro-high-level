import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./css/App.css";
import SideBar from "./components/sidebar/SideBar";
import Content from "./components/content/Content";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import UserComponent from './components/UserComponent';
import UserComponentById from './components/UserComponentById';
import Routes from "./routes";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isOpen: false,
      isMobile: true
    };

    this.previousWidth = -1;
  }

  updateWidth() {
    const width = window.innerWidth;
    const widthLimit = 576;
    const isMobile = width <= widthLimit;
    const wasMobile = this.previousWidth <= widthLimit;

    if (isMobile !== wasMobile) {
      this.setState({
        isOpen: !isMobile
      });
    }

    this.previousWidth = width;
  }

  /**
   * Add event listener
   */
  componentDidMount() {
    this.updateWidth();
    window.addEventListener("resize", this.updateWidth.bind(this));
  }

  /**
   * Remove event listener
   */
  componentWillUnmount() {
    window.removeEventListener("resize", this.updateWidth.bind(this));
  }

  toggle = () => {
    this.setState({ isOpen: !this.state.isOpen });
  };

  render() {
    return (
      <div className="App wrapper">

        <SideBar toggle={this.toggle} isOpen={this.state.isOpen} />

        <Routes/>
      </div>

    );
  }
}

export default App;
