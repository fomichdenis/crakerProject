import React, {Component} from 'react';
import './Book.css';
import { Link } from 'react-router';
import book0 from './book0.jpg';
import book1 from './book1.jpg';
import book2 from './book2.jpg';

var bookinfo = [
    {
      author: 'Александр Пушкин',
      bookname: '"Собрание сочинений, 1832 год"',
      yeardone: '1832',
      annotation: 'В сборнике собраны стихи А.С. Пушкина, написанные им ' +
        'в начале 30-х годов, в том числе его малоизвестные творения.',
      series: '-',
      seriesNum: '-',
      genre: 'Сборник',
      imgsrc: book0
    },
    {
      author: 'Александр Твардовский',
      bookname: '"Василий Теркин"',
      yeardone: '1942',
      annotation: 'Знаменитая поэма А.Твардовского "Василий Тёркин" поистине ' +
        'стала национальным эпосом, а ее главный герой - выразителем ' +
        'народного духа, символом победы в Великой Отечественной войне. ' +
        'В настоящее издание вошла также поэма "Тёркин на том свете", ' +
        'неоднократно запрещенная к публикации и подвергавшаяся острой ' +
        'критике за свою злободневность и сатирическую направленность.',
      series: '-',
      seriesNum: '-',
      genre: 'Поэма',
      imgsrc: book1
    },
    {
      author: 'Кир Булычев',
      bookname: '"Сто лет тому вперед"',
      yeardone: '1978',
      annotation: 'В книгу вошли две повести Кира Булычева — «Сто лет тому ' +
        'вперед» и «Пленники астероида». В первой рассказывается о том, как ' +
        'злобные космические пираты, прилетевшие на Землю с далекой планеты ' +
        'Крокрыс, пытались завладеть чудесным изобретением — миелофоном, и о ' +
        'том, как Алиса, отправившись из будущего в наше время, находит здесь ' +
        'верных друзей и вместе с ними встает на пути бандитов-инопланетян.  ' +
        'Во второй повести Алиса и робот Посейдон разгадывают тайну ' +
        'загадочного астероида, пленниками которого они стали. В издании ' +
        'воспроизводятся 115 рисунков самого известного иллюстратора ' +
        'писателя — Евгения Мигунова.',
      series: '"Приключения Алисы Селезневой"',
      seriesNum: '-',
      genre: 'Повесть',
      imgsrc: book2
    }
  ];

class Bookdata extends Component {
  render() {
    var bookname = this.props.data.bookname,
        author = this.props.data.author,
        yeardone = this.props.data.yeardone,
        annotation = this.props.data.annotation,
        series = this.props.data.series,
        seriesNum = this.props.data.seriesNum,
        genre = this.props.data.genre;
    return (
      <div className='bookdata'>
        <div className='table-responsive'>
          <table className='table table-striped table-bordered table-hover'>
            <tbody className='book__tablebody'>
              <tr className='book__tr'>
                <td className='book__td1'>
                  Название:
                </td>
                <td className='book__td2'>
                  <strong className='book__bookname'>{bookname}</strong>
                </td>
              </tr>
              <tr className='book__tr'>
                <td className='book__td1'>
                  Автор:
                </td>
                <td className='book__td2'>
                  <p className='book__author'>{author}</p>
                </td>
              </tr>
              <tr className='book__tr'>
                <td className='book__td1'>
                  Год издания:
                </td>
                <td className='book__td2'>
                  <p className='book__yeardone'>{yeardone}</p>
                </td>
              </tr>
              <tr className='book__tr'>
                <td className='book__td1'>
                  Аннотация:
                </td>
                <td className='book__td2'>
                  <p className='book__annotation'>{annotation}</p>
                </td>
              </tr>
              <tr className='book__tr'>
                <td className='book__td1'>
                  Серия:
                </td>
                <td className='book__td2'>
                  <p className='book__series'>{series}</p>
                </td>
              </tr>
              <tr className='book__tr'>
                <td className='book__td1'>
                  Номер в серии:
                </td>
                <td className='book__td2'>
                  <p className='book__seriesNum'>{seriesNum}</p>
                </td>
              </tr>
              <tr className='book__tr'>
                <td className='book__td1'>
                  Жанр:
                </td>
                <td className='book__td2'>
                  <p className='book__genre'>{genre}</p>
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
        <div className='book__imgblock'>
          <img
            className='book__img'
            src={bookinfo[this.props.bookid].imgsrc}
            alt='No_img'
          />
        </div>
        <div className='infoblock'>
          <Bookdata data={bookinfo[this.props.bookid]} />
        </div>
      </div>
    );
  }
};

class Book extends Component {
  render() {
    return (
      <div className='book__app'>
        <Page bookid={this.props.params.bookId} />
      </div>
    );
  }
};

export default Book;
