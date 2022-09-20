import axios from 'axios';
import { useEffect, useState } from 'react';
import Navbar from '../../components/Navbar';
import { Participante } from '../../models/participante';
import { BASE_URL } from '../../utils/request';
import './styles.css';

function RecordList() {
  const [participantes, setParticipantes] = useState<Participante[]>([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/participantes`).then((response) => {
      setParticipantes(response.data);
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
              {participantes.map((participantes) => {
                return (
                  <tr key={participantes.id}>
                    <td>{participantes.nome}</td>
                    <td>{participantes.opcao}</td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
}

export default RecordList;
