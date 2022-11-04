/*   
  		this.idPacote = IdPacote;
		this.idPassageiro = IdPassageiro;
		this.dataViagem = DataViagem;
		this.dataHora = DataHora;
		this.destino = Destino;
		this.origem = Origem;

  */

import { useState } from "react";
import {
  Grid,
  Button,
  TextField,
  Tab,
  Tooltip,
  CircularProgress,
} from "@mui/material";

function AtualizarPacote({ pedido, pacote, setLinhas, setAbaAtual }) {
  console.log("pacote");
  console.log(pacote);
  const [form, setForm] = useState({
    idpacote: pacote.idpacote,
    idPassageiro: pacote.idPassageiro,
    dataViagem: pacote.dataViagem,
    dataHora: pacote.dataHora,
    destino: pacote.destino,
    origem: pacote.origem,
  });

  const handleChange = (campo, value) =>
    setForm({
      ...form,
      [campo]: value,
    });

  return (
    <div>
      <h2>Cadastrar novo Pacote</h2>
      <Grid
        container
        xs={12}
        direction="column"
        justifyContent="center"
        spacing={2}
      >
        <Grid item>
          <TextField
            fullWidth
            label="Nome Completo"
            value={form.nome}
            onChange={(e) => handleChange("nome", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Numero do Pacote"
            value={form.cep}
            onChange={(e) => handleChange("cpf", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Destino"
            value={form.destino}
            onChange={(e) => handleChange("destino", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Origem"
            value={form.origem}
            onChange={(e) => handleChange("origem", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Data da Viagem"
            value={form.dataViagem}
            onChange={(e) => handleChange("dataViagem", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Hora da Viagem"
            value={form.dataHora}
            onChange={(e) => handleChange("dataHora", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <Button
            style={{
              outline: "none",
              fontWeight: "bold",
            }}
            variant="contained"
            onClick={async () => {
              await pedido("PUT", form, `/api/pacotes/${pacote.id}`);
              const data = await pedido("GET", null, "/api/pacotes");
              setLinhas(data);
              setAbaAtual("get-all-pacote");
            }}
          >
            Salvar
          </Button>
        </Grid>
      </Grid>
    </div>
  );
}

export default AtualizarPacote;
