import React from 'react';
import UserService from '../services/UserService';
import Content from "../components/content/Content";
import classNames from "classnames";
import { Container } from "react-bootstrap";
// function Dashboard(props) {
//     console.log("Dashboard props", props);
//     return (

//         <div className="App">

//             <h2>I'm the dashboard.</h2>
//             <p>You love me &lt;3 </p>
//         </div>
//     );
// }

class Dashboard extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            users: []
        }
    }

    componentDidMount() {
        UserService.getUsers().then((response) => {
            this.setState({ users: response.data })
        });
    }

    render() {
        return (
        <Container
                        fluid
                        className={classNames("content", { "is-open": this.props.isOpen })}
                      >
            <div>
                <h1 className="text-center">Dashboard</h1>
                <table className="table table-striped">
                    <thead>
                        <tr>

                            <td>Id</td>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Middle Name</td>
                            <td>Email Id</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                                user =>
                                    <tr key={user.id}>
                                        <td>{user.id}</td>
                                        <td>{user.firstName}</td>
                                        <td>{user.lastName}</td>
                                        <td> {user.middleName}</td>
                                        <td>{user.email}</td>
                                    </tr>
                            )
                        }

                    </tbody>
                </table>

            </div>
</Container>
        )
    }
}

export default Dashboard;