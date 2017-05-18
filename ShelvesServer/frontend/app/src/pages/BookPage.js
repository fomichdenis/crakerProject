import React, { Component } from 'react';

import Request from '../api/RequesterAPI.js'
import SideInfo from '../components/SideInfo.js'

class BookPage extends Component {

    constructor(props) {
        super(props);
        this.state = { book:[]};
        Request.send("GET", `/webresources/books/find?id=${this.props.params.id}`).then(r => this.setState({ book: r }));
    }

    render() {
        return (
            <div className="row">
                <div className="col-md-3">
                    <SideInfo photoSrc={`assets/img/books/${this.state.book.bookid}.jpg`}>
                        <b>name: {this.state.book.bookname}</b><br />
                        <b>author: {this.state.book.authorid}</b><br />
                    </SideInfo>
                </div>

                <div className="col-md-9">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <div className="row">
                                <div className="col-md-8">
                                    {/*info*/}
                                    <h3>{this.state.book.bookname}</h3><br />
                                    <b>author: {this.state.book.authorid}</b><br />
                                    <div><b>Rating</b></div>
                                    <div><b>*****</b></div>
                                    <div><b>Annotation</b></div>
                                    <div>{this.state.book.annotation}</div>
                                </div>
                                <div className="col-md-4">
                                    {/*statistics*/}
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
