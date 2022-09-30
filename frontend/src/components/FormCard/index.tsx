import axios from 'axios';
import { useState } from 'react';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type FormData = {
  cpf: string;
  nome: string;
  opcao: string;
};

function FormCard() {
  const [formData, setFormData] = useState<FormData>({
    cpf: '',
    nome: '',
    opcao: '',
  });

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const name = event.target.name;
    const value = event.target.value;

    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    fetch(`${BASE_URL}/participantes`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    }).then((response) => {
      setFormData(formData);
    });
  };

  return (
    <>
      <div className="registro-container">
        <h2>Registre sua opção</h2>
      </div>
      <form onSubmit={handleSubmit}>
        <div className="container">
          <div className="card-container input-group mb-3">
            <span className="input-group-text py-3">CPF</span>
            <input
              type="text"
              name="cpf"
              value={formData.cpf}
              className="form-control"
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-sm"
              placeholder="Somente números"
              onChange={handleChange}
            />
          </div>
          <div className="card-container input-group mb-3">
            <span className="input-group-text py-3">Nome</span>
            <input
              type="text"
              name="nome"
              value={formData.nome}
              className="form-control"
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-sm"
              placeholder="Informe seu nome"
              onChange={handleChange}
            />
          </div>
          <div className="card-container input-group mb-3">
            <span className="input-group-text py-3">Opção</span>
            <input
              type="text"
              name="opcao"
              value={formData.opcao}
              className="form-control"
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-sm"
              placeholder="Informe sua escolha"
              onChange={handleChange}
            />
          </div>
          <div className="py-3">
            <button className="btn btn-dark" type="submit">
              Cadastrar
            </button>
          </div>
        </div>
      </form>
    </>
  );
}

export default FormCard;
