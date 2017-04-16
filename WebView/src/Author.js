import React, {Component} from 'react';
import './Author.css';
import { Link } from 'react-router';
import author0 from './author0.jpg';
import author1 from './author1.jpg';
import author2 from './author2.jpg';

var authorinfo = [
    {
      name: 'Александр Сергеевич Пушкин',
      birth: '1799',
      death: '1837',
      about: 'Русский поэт, драматург и прозаик, заложивший основы русского ' +
      'реалистического направления, критик и теоретик литературы, историк, ' +
      'публицист; один из самых авторитетных литературных деятелей первой ' +
      'трети XIX века. Пушкин в своем творчестве, являющемся художественной ' +
      'энциклопедией российской действительности, затронул коренные ' +
      'общественные проблемы своего времени: самодержавие и народ, ' +
      'личность и государство, трагическое одиночество передовой ' +
      'дворянской интеллигенции Золотого века. Ещё при жизни Пушкина ' +
      'сложилась его репутация величайшего национального русского ' +
      'поэта. Пушкин рассматривается как основоположник современного ' +
      'русского литературного языка.',
      imgsrc: author0
    },
    {
      name: 'Александр Трифонович Твардовский',
      birth: '1910',
      death: '1971',
      about: 'Русский советский писатель, поэт, журналист. Главный редактор ' +
      'журнала «Новый мир» (1950—1954; 1958—1970). Член Центральной ' +
      'ревизионной комиссии КПСС (1952—1956), кандидат в члены ЦК ' +
      'КПСС (1961—1966).',
      imgsrc: author1
    },
    {
      name: 'Кир Булычев',
      birth: '1934',
      death: '2003',
      about: 'Настоящее имя Игорь Всеволодович Можейко. Русский советский ' +
      'писатель-фантаст, драматург, сценарист, литературовед; историк, ' +
      'востоковед, фалерист. Лауреат Государственной премии СССР (1982). ' +
      'Псевдоним скомпонован из имени жены Киры и девичьей фамилии ' +
      'матери писателя, Марии Михайловны Булычёвой.',
      imgsrc: author2
    }
  ];

class Authordata extends Component {
  render() {
    var name = this.props.data.name,
        birth = this.props.data.birth,
        death = this.props.data.death,
        about = this.props.data.about;
    return (
      <div className='authordata'>
        <div className='table-responsive'>
          <table className='table table-striped table-bordered table-hover'>
            <tbody className='author__tablebody'>
              <tr className='author__tr'>
                <td className='author__td1'>
                  Имя:
                </td>
                <td className='author__td2'>
                  <p className='author__name'>{name}</p>
                </td>
              </tr>
              <tr className='author__tr'>
                <td className='author__td1'>
                  Год рождения:
                </td>
                <td className='author__td2'>
                  <p className='author__birth'>{birth}</p>
                </td>
              </tr>
              <tr className='author__tr'>
                <td className='author__td1'>
                  Год смерти:
                </td>
                <td className='author__td2'>
                  <p className='author__death'>{death}</p>
                </td>
              </tr>
              <tr className='author__tr'>
                <td className='author__td1'>
                  Об авторе:
                </td>
                <td className='author__td2'>
                  <p className='author__about'>{about}</p>
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
        <div className='author__imgblock'>
          <img
            className='author__img'
            src={authorinfo[this.props.authorid].imgsrc}
            alt='No_img'
          />
        </div>
        <div className='infoblock'>
          <Authordata data={authorinfo[this.props.authorid]} />
        </div>
      </div>
    );
  }
};

class Author extends Component {
  render() {
    return (
      <div className='author__app'>
        <Page authorid={this.props.params.authorId}/>
      </div>
    );
  }
};

export default Author;
