import React, { Component } from 'react'
import { Link } from 'react-router'

class NotFound extends Component {
    render() {
        return (
            <div className='container'>
                <div className='row'>
                    <div className='col-md-12'>
                        Page doesn't exist. Go to <Link to='/'>main</Link>.
                    </div>
                </div>
            </div>
        )
    }
}
export default NotFound