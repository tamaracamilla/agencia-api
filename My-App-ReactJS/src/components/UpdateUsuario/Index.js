/*	this.idUsuario = IdUsuario;
			this.nome = Nome;
			this.senha = Senha;
			this.login = Login;
			 
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

function AtualizarUsuario({ pedido, usuario, setLinhas, setAbaAtual }) {
  console.log("usuario");
  console.log(usuario);
  const [form, setForm] = useState({
    nome: usuario.nome,
    senha: usuario.senha,
    login: usuario.login,
  });

  const handleChange = (campo, value) =>
    setForm({
      ...form,
      [campo]: value,
    });

  return (
    <div>
      <h2>Cadastrar novo Usuário</h2>
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
            label="Senha"
            value={form.senha}
            onChange={(e) => handleChange("senha", e.target.value)}
            variant="outlined"
          ></TextField>
        </Grid>
        <Grid item>
          <TextField
            fullWidth
            label="Login"
            value={form.login}
            onChange={(e) => handleChange("login", e.target.value)}
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
              await requisicao("PUT", form, `/api/usuarios/${usuario.id}`);
              const data = await requisicao("GET", null, "/api/usuarios");
              setLinhas(data);
              setAbaAtual("get-all-usuario");
            }}
          >
            Salvar{" "}
          </Button>
        </Grid>
      </Grid>
    </div>
  );
}

export default AtualizarUsuario;
