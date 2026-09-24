<?php
header("Content-Type: application/json");
$conn = new mysqli("localhost", "root", "", "helpdesk_db");

$usuario_id = $_GET['usuario_id'] ?? 0;

$result = $conn->query("SELECT * FROM chamados"); 

$chamados = [];
while($row = $result->fetch_assoc()) {
    $chamados[] = $row;
}
echo json_encode(["dados_com_erro" => $chamados]); 
?>
