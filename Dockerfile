# Imagem base
FROM python:3.10

# Diretório de trabalho
WORKDIR /app

# Copia os arquivos
COPY . .

# Instala as dependências
RUN pip install -r requirements.txt

# Porta usada
EXPOSE 5000

# Comando para iniciar o servidor
CMD ["python", "app.py"]