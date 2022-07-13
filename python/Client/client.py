class Client:
    def __init__(self, server):
        self.server = server
        server.register(self)

    def say(self):
        return self.server.say_greeting()

    def send(self, message):
        return self.server.receive(message)

    def receive(self, message):
        print(f"{message}")