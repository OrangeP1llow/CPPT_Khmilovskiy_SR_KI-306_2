#Похідний клас "Штурмова гвинтівка":

from AssaultRifle import AssaultRifle

class CustomAssaultRifle(AssaultRifle):
    def __init__(self, model, ammunition, caliber, price, weight, camouflage, customization):
        super().__init__(model, ammunition, caliber)
        # Додаткові властивості для похідного класу
        self.price = price
        self.weight = weight
        self.camouflage = camouflage
        self.customization = customization

    def customize(self, new_features):
        self.customization = new_features
        return f"Customization added: {self.customization}"

    def change_caliber(self, new_caliber):
        self.caliber = new_caliber
        return f"Caliber changed to: {self.caliber} mm"

    def calculate_total_price(self, custom_price):
        total_price = custom_price + self.price
        return f"Total price (including customization): {total_price} $"

    def сhange_weight(self, change):
        self.weight += change
        return f"Total weight (including customization): {self.weight} kg"

    def change_camouflage(self, new_camouflage):
        self.camouflage = new_camouflage
        return f"Camouflage changed to: {self.camouflage}"

    def display_info(self):
        base_info = super().display_info()
        return f"{base_info}\nPrice: ${self.price}\nWeight: {self.weight} kg\nCamouflage: {self.camouflage}\nCustomization: {self.customization}"