from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route("/login", methods=["POST"])
def login():
    data = request.json
    email = data.get("email")
    senha = data.get("senha")

    # Exemplo didático
    if email == "teste@email.com" and senha == "1234":
        return jsonify({"mensagem": "Login bem-sucedido!"})
    else:
        return jsonify({"mensagem": "Login inválido"}), 401

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)