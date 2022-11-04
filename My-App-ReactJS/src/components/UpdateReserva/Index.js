import { useState } from "react";
import {
  Grid,
  Button,
  TextField,
  Tab,
  Tooltip,
  CircularProgress,
} from "@mui/material";

function AtualizarReserva({ pedido, reserva, setLinhas, setAbaAtual }) {
  console.log("reserva");
  console.log(reserva);
  const [form, setForm] = useState({
    nome: reserva.nome,
    cpf: reserva.cpf,
    destino: reserva.destino,
    telefone1: reserva.telefone1,
    origem: reserva.origem,
    Idpacote: reserva.Idpacote,
  });

  const handleChange = (campo, value) =>
    setForm({
      ...form,
      [campo]: value,
    });

  return (
    <div>
      <h2>Cadastrar nova Reserva</h2>
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
            label="CPF"
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
            label="Telefone 1"
            value={form.telefone1}
            onChange={(e) => handleChange("telefone1", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>

        <Grid item>
          <TextField
            fullWidth
            label="Numero do Pacote"
            value={form.Idpacote}
            onChange={(e) => handleChange("IdPacote", e.target.value)}
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
              await pedido("PUT", form, `/api/reservas/${reserva.id}`);
              const data = await pedido("GET", null, "/api/reservas");
              setLinhas(data);
              setAbaAtual("get-all-reserva");
            }}
          >
            Salvar
          </Button>
        </Grid>
      </Grid>
    </div>
  );
}

export default AtualizarReserva;
