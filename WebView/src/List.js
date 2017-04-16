import React, {Component} from 'react';
import './List.css';
import { Link } from 'react-router';
import book_small from './book_small.jpg';

var my_books = [[
  {
    author: 'Александр Пушкин',
    bookname: '"Собрание сочинений, 1832 год"',
    comment: 'Мой любимый автор, всегда любил его стихи'
  },
  {
    author: 'Александр Твардовский',
    bookname: '"Василий Теркин"',
    comment: '"Я согласен на медаль!"'
  },
  {
    author: 'Кир Булычев',
    bookname: '"Сто лет тому вперед"',
    comment: 'Интересно, почему в фильме фамилия Коли - Герасимов, а не Наумов, как в книге?'
  }
]];

class Article extends Component {
  constructor() {
    super();
    this.state = {
      visible: false,
      readmoreText: 'Показать комментарий пользователя'
    };
  }
  readmoreClick(e) {
    e.preventDefault();
    if (this.state.visible === false) {
      this.setState({visible: true, readmoreText: 'Cкрыть комментарий'});
    } else {
      this.setState({visible: false, readmoreText: 'Показать комментарий пользователя'});
    }
  };
  render() {
    var author = this.props.data.author,
        bookname = this.props.data.bookname,
        comment = this.props.data.comment,
        visible = this.state.visible,
        address = '/book/' + this.props.ind;

    return (
      <div className='booklist__article'>
        <div className='table-responsive'>
          <table className='table table-bordered table-hover'>
            <tbody className='booklist__tablebody'>
              <tr className='booklist__tr'>
                <td className='col-md-1'>
                  <div className='center-block'>
                    <img
                      className='img-responsive'
                      src={book_small}
                      alt='No img'
                    />
                  </div>
                </td>
                <td className='col-md-4'>
                  <div className='booklist__context'>
                    <table className='table table-striped table-bordered'><tbody>
                      <tr><td><strong className='booklist__author'>{author}</strong></td></tr>
                      <tr><td><Link className='booklist__bookname' to={address}>{bookname}</Link></td></tr>
                      <tr><td><br /></td></tr>
                      <tr><td><a href="#"
                        onClick={this.readmoreClick.bind(this)}
                        className={'booklist__readmore'}>
                        {this.state.readmoreText}
                      </a></td></tr>
                      <tr><td><p className={'booklist__comment ' + (visible ? '': 'none')}>{comment}</p></td></tr>
                    </tbody></table>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    )
  };
};
/*Article.propTypes = {
  data: React.PropTypes.shape({
    author: React.PropTypes.string.isRequired,
    comment: React.PropTypes.string.isRequired
  })
};*/

class Books extends Component {
  render() {
    var data = this.props.data;
    var booksTemplate;

    if (data.length > 0) {
      booksTemplate = data.map(function(item, index) {
        return (
          <div key={index}>
            <Article data={item} ind={index} />
          </div>
        )
      })
    } else {
      booksTemplate = <p>Нет записей о книгах</p>
    }

    return (
      <div className='books'>
        {booksTemplate}
        <p className='text-center'><strong className={'books__count ' + (data.length > 0 ? '':'none') }>Всего записей: {data.length}</strong></p>
      </div>
    );
  }
};
/*Books.propTypes = {
  data: React.PropTypes.array.isRequired
};*/

class List extends Component {
  render() {
    var useraddress = '/user/' + this.props.params.userId;
    return (
      <div className='booklist__app'>
        <h3 className='text-center'>Книги пользователя</h3>
        <Books data={my_books[this.props.params.userId]} />
        <h4 className='text-center'><Link to={useraddress}>Назад</Link></h4>
      </div>
    );
  }
};

export default List;
