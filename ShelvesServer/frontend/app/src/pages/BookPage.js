import React, { Component } from 'react';

import Request from '../api/RequesterAPI.js'
import SideInfo from '../components/SideInfo.js'

class BookPage extends Component {

    constructor(props) {
        super(props);
        this.state = { bookInfo:[]};
        Request.get("POST", "books", this.props.id).then(r => this.setState({ bookInfo: r }));
    }

    render() {
        return (
            <div className="row">
                <div className="col-md-2">
                    <SideInfo photoSrc="../assets/img/usersImg/user1.jpg">
                        <b>name: {this.state.bookInfo.bookName}</b><br />
                        <b>author: {this.state.bookInfo.bookAutor}</b><br />
                    </SideInfo>
                </div>

                <div className="col-md-10">
                    {/*statistics*/}
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <div className="row">
                                <div className="col-md-8">
                                    <div><b>Rating</b></div>
                                    <div><b>*****</b></div>
                                    <div><b>Annotation</b></div>
                                    <div>{this.state.bookInfo.bookAnnot}</div>
                                </div>
                                <div className="col-md-4">
                                    statistics
                                    <div className="progress">
                                        <div className="progress-bar progress-bar-success" style={{width: 70}}>
                                            <span className="sr-only" />
                                        </div>
                                        <div className="progress-bar progress-bar-warning progress-bar-striped" style={{width: 50}}>
                                            <span className="sr-only" />
                                        </div>
                                        <div className="progress-bar progress-bar-danger" style={{width: 30}}>
                                            <span className="sr-only" />
                                        </div>
                                    </div>
                                    <div className="progress">
                                        <div className="progress-bar progress-bar-success" style={{width: 70}}>
                                            <span className="sr-only" />
                                        </div>
                                        <div className="progress-bar progress-bar-warning progress-bar-striped" style={{width: 50}}>
                                            <span className="sr-only" />
                                        </div>
                                        <div className="progress-bar progress-bar-danger" style={{width: 30}}>
                                            <span className="sr-only" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default BookPage;
