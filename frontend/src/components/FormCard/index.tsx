import './styles.css';

function FormCard() {
  return (
    <>
      <div className="registro-container">
        <h2>Registre sua opção</h2>
      </div>
      <div className="container">
        <div className="card-container input-group mb-3">
          <span className="input-group-text py-3">CPF</span>
          <input
            type="text"
            className="form-control"
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            placeholder="Somente números"
          />
        </div>
        <div className="card-container input-group mb-3">
          <span className="input-group-text py-3">Nome</span>
          <input
            type="text"
            className="form-control"
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            placeholder="Informe seu nome"
          />
        </div>
        <div className="card-container input-group mb-3">
          <span className="input-group-text py-3">Opção</span>
          <input
            type="text"
            className="form-control"
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            placeholder="Informe sua escolha"
          />
        </div>
        <div className="py-3">
          <button className="btn btn-dark" type="submit">
            Cadastrar
          </button>
        </div>
      </div>
    </>
  );
}

export default FormCard;
