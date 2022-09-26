import axios from 'axios';
import { useEffect, useState } from 'react';
import { Participante } from '../../types/participante';
import { AxiosParams } from '../../types/vendor/axios';
import { BASE_URL } from '../../utils/request';
import './styles.css';

function RecordList() {
  const [page, setPage] = useState<Participante[]>([]);

  useEffect(() => {
    const params: AxiosParams = {
      method: 'GET',
      url: `${BASE_URL}/participantes`,
      params: {
        page: 0,
        size: 12,
      },
    };
    axios(params).then((response) => {
      setPage(response.data);
    });
  }, []);

  return (
    <>
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
              {page?.map((participantes) => {
                return (
                  <tr key={participantes?.id}>
                    <td>{participantes?.nome}</td>
                    <td>{participantes?.opcao}</td>
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
