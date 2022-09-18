import axios from 'axios';
import { useEffect } from 'react';
import Navbar from '../../components/Navbar';
import './styles.css';

function RecordList() {
  useEffect(() => {
    axios.get('http://localhost:8080/participantes').then((response) => {
      console.log(response.data);
    });
  }, []);

  return (
    <>
      <Navbar />
      <div className="container col-sm-8 record-container">
        <h2 className=" record-title">Participantes</h2>
        <div className="table-responsive">
          <table className="table table-striped table-sm">
            <thead className="record-table">
              <tr>
                <th>Cadastrados</th>
                <th>Opções</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Fulano de tal</td>
                <td>Bolo de rolo</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
}

export default RecordList;
