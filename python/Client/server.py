class Server:
    def __init__(self):
        self.clients = []

    def register(self, client):
        self.clients.append(client)

    def say_greeting(self):
        return "Hello client"

    def receive(self, message):
        return f"echo {message}"

    def boradcast(self):
        for c in self.clients:
            c.receive("bradcast message")