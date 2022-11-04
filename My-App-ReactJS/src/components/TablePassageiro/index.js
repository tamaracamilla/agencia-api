import { DataGrid } from "@mui/x-data-grid";
import { Button } from "@mui/material";

function TabelaPassageiro({ linhas, colunas, setLinhas, pedido }) {
  return (
    <>
      <Button
        style={{
          outline: "none",
          fontWeight: "bold",
        }}
        variant="contained"
        onClick={async () => {
          const data = await pedido("GET", null, "/api/passageiros");
          setLinhas(data);
        }}
      >
        Salvar {" "}
      </Button>

      <DataGrid
        style={{ height: 500, width: "100%" }}
        rows={linhas}
        columns={colunas}
        pageSize={20}
        rowsPerPageOptons={[10]}
      />
    </>
  );
}

export default TabelaPassageiro;
