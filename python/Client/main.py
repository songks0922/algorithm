from client import Client
from server import Server

server = Server()

client_01 = Client(server)
client_02 = Client(server)
client_03 = Client(server)

server.boradcast()