import React, {Component} from 'react';
import './User.css';
import { Link } from 'react-router';
import user0 from './user0.jpg';

var userinfo = [
    {
      nick: 'Pupkinator',
      name: 'Василий Пупкин',
      sex: 'male',
      about: 'Люблю читать книги с детства, особенно люблю "Приключения ' +
        'Алисы" Кира Булычева, а также русскую поэзию XIX века. Недавно засел ' +
        'за "Василия Теркина" Твардовского, очень нравится. На фото я со ' +
        'своим лучшим другом.',
      imgsrc: user0
    }
  ];

class Userdata extends Component {
  render() {
    var nick = this.props.data.nick,
        name = this.props.data.name,
        sex = this.props.data.sex,
        about = this.props.data.about,
        listaddress = '/user/' + this.props.ind + '/list';
    return (
      <div className='userdata'>
        <div className='table-responsive'>
          <table className='table table-striped table-bordered table-hover'>
            <tbody className='user__tablebody'>
              <tr className='user__tr'>
                <td className='user__td1'>
                  Ник:
                </td>
                <td className='user__td2'>
                  <strong className='user__nick'>{nick}</strong>
                </td>
              </tr>
              <tr className='user__tr'>
                <td className='user__td1'>
                  Имя пользователя:
                </td>
                <td className='user__td2'>
                  <p className='user__name'>{name}</p>
                </td>
              </tr>
              <tr className='user__tr'>
                <td className='user__td1'>
                  Пол:
                </td>
                <td className='user__td2'>
                  <p className='user__sex'>{sex}</p>
                </td>
              </tr>
              <tr className='user__tr'>
                <td className='user__td1'>
                  О себе:
                </td>
                <td className='user__td2'>
                  <p className='user__about'>{about}</p>
                </td>
              </tr>
              <tr className='user__tr'>
                <td className='user__td1'>
                  Список книг:
                </td>
                <td className='user__td2'>
                  <button type="button" className="btn btn-info"><Link role="button" className='user__booklist' to={listaddress}>Перейти</Link></button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    );
  }
};

class Page extends Component {
  render() {
    return (
      <div className='wrapper'>
        <div className='user__imgblock'>
          <img
            className='user__img'
            src={userinfo[this.props.userid].imgsrc}
            alt='No_img'
          />
        </div>
        <div className='infoblock'>
          <Userdata data={userinfo[this.props.userid]} ind={this.props.userid} />
        </div>
      </div>
    );
  }
};

class User extends Component {
  render() {
    return (
      <div className='user__app'>
        <Page userid={this.props.params.userId}/>
      </div>
    );
  }
};

export default User;
