#Базовий клас "Автомат":
class AssaultRifle:
    def __init__(self, model, ammunition, caliber):
        self.model = model
        self.ammunition = ammunition
        self.caliber = caliber

    def reload(self, rounds):
        if rounds > 0:
            self.ammunition += rounds
            return f"Reloaded with {rounds} rounds. \nCurrent ammunition count: {self.ammunition}"
        else:
            return"Invalid number of rounds. Must be greater than zero."

    def burst_fire(self, bursts):
        bullets_to_fire = bursts * 3
        if self.ammunition >= bullets_to_fire:
            self.ammunition -= bullets_to_fire
            for i in range(bursts):
                print("Burst fire! (3 bullets used)")
            return f"Remaining ammunition: {self.ammunition}"
        else:
            return "Not enough ammunition to fire."

    def automatic_fire(self, bullets):
        if self.ammunition >= bullets:
            self.ammunition -= bullets
            for i in range(bullets):
                print(f"Automatic Fire! (Bullet used: {i + 1})")
            return f"Remaining ammunition: {self.ammunition}"
        else:
            return "Not enough ammunition to fire."

    def single_fire(self, bullets):
        bullets_to_fire = bullets
        if self.ammunition >= bullets_to_fire:
            self.ammunition -= bullets_to_fire
            for i in range(bullets):
                print("Single fire! (1 bullet used)")
            return f"Remaining ammunition: {self.ammunition}"
        else:
            return "Not enough ammunition to fire."

    def display_info(self):
        return f"Model: {self.model}\nCaliber: {self.caliber}\nAmmunition: {self.ammunition}"