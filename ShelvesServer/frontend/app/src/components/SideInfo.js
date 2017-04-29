import React, { Component } from 'react';


class SideInfo extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="panel panel-default">
                <div className="panel-body">
                    <div><img id='photo' src={this.props.photoSrc} alt='You are too ugly' /></div>
                <hr />
                    <div>
                        {this.props.children}
                    </div>
                </div>
                <button className="btn btn-default btn-xs btn-block" href='#'>Edit</button>
            </div>
        );
    }
}

export default SideInfo;