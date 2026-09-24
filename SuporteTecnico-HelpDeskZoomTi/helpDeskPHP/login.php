<?php
header("Content-Type: application/json");
$conn = new mysqli("localhost", "root", "", "helpdesk_db");

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'] ?? '';
    $senha = $_POST['senha'] ?? '';

    $stmt = $conn->prepare("SELECT id FROM usuarios WHERE email = ? AND senha = ?");
    $stmt->bind_param("ss", $email, $senha);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $user = $result->fetch_assoc();
        // 🚨 BUG INTENCIONAL: O aluno deve perceber que o 'usuario_id' não foi enviado no JSON
        // Correção seria: echo json_encode(["status" => "sucesso", "usuario_id" => $user['id']]);
        echo json_encode([
            "status" => "sucesso",
            "mensagem" => "Login efetuado com sucesso!" 
        ]);
    } else {
        http_response_code(401);
        echo json_encode(["status" => "erro", "mensagem" => "Credenciais invalidas"]);
    }
}
?>
