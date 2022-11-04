import { useState } from "react";
import {
  Grid,
  Button,
  TextField,
  Tab,
  Tooltip,
  CircularProgress,
} from "@mui/material";

function AtualizarPassageiro({ pedido, passageiro, setLinhas, setAbaAtual }) {
  console.log("passageiro");
  console.log(passageiro);
  const [form, setForm] = useState({
    nome: passageiro.nome,
    email: passageiro.email,
    cpf: passageiro.cpf,
    telefone1: passageiro.telefone1,
    telefone2: passageiro.telefone2,
    cep: passageiro.cep,
    bairro: passageiro.bairro,
    numero: passageiro.numero,
    logradouro: passageiro.logradouro,
    IdUsuario: passageiro.IdUsuario,
  });

  const handleChange = (campo, value) =>
    setForm({
      ...form,
      [campo]: value,
    });

  return (
    <div>
      <h2>Cadastrar novo Passageiro</h2>
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
            label="Email"
            value={form.email}
            onChange={(e) => handleChange("email", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="CPF"
            value={form.cep}
            onChange={(e) => handleChange("cpf", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Telefone 1"
            value={form.telefone1}
            onChange={(e) => handleChange("telefone1", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Telefone 2"
            value={form.telefone2}
            onChange={(e) => handleChange("telefone2", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="CEP"
            value={form.cep}
            onChange={(e) => handleChange("cep", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Bairro"
            value={form.bairro}
            onChange={(e) => handleChange("bairro", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Numero"
            value={form.numero}
            onChange={(e) => handleChange("numero", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Logradouro"
            value={form.logradouro}
            onChange={(e) => handleChange("logradouro", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Identidade do Usuário"
            value={form.IdUsuario}
            onChange={(e) => handleChange("IdUsuario", e.target.value)}
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
              await pedido("PUT", form, `/api/passageiros/${passageiro.id}`);
              const data = await pedido("GET", null, "/api/passageiros");
              setLinhas(data);
              setAbaAtual("get-all-passageiro");
            }}
          >
            Salvar
          </Button>
        </Grid>
      </Grid>
    </div>
  );
}

export default AtualizarPassageiro;
