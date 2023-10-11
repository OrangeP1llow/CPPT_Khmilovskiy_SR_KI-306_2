#Main функція програми:

from AssaultRifle import AssaultRifle
from CustomAssaultRifle import CustomAssaultRifle

def main():
    rifle1 = AssaultRifle("AR-15", 30, "5.56")

    print("\nAssaultRifle Info:")
    print(rifle1.display_info())
    print()

    #Використання методу перезарядки
    reload_message = rifle1.reload(20)
    print(reload_message)

    # Використання методу стрільби по три патрони
    print()
    burst_fire_message = rifle1.burst_fire(3)
    print(burst_fire_message)

    # Використання методу автоматичної стрільби
    print()
    automatic_fire_message = rifle1.automatic_fire(11)
    print(automatic_fire_message)

    # Використання методу одиночної стрільби
    print()
    single_fire_message = rifle1.single_fire(25)
    print(single_fire_message)


    custom_rifle1 = CustomAssaultRifle("CustomAR-15", 21, "5.56", 1000, 1.2, "Default", "None")
    print()
    print("\nCustomAssaultRifle Info:")
    print(custom_rifle1.display_info())

    print()
    print(custom_rifle1.customize('4x Scope'))
    print(custom_rifle1.change_caliber("7.62"))
    print(custom_rifle1.calculate_total_price(300))
    print(custom_rifle1.сhange_weight(0.5))
    print(custom_rifle1.change_camouflage("\'Mountain camouflage\'"))

    print("\n############################")
    print("Usage of inherited methods: \n")
    # Використання методу перезарядки
    reload_message = custom_rifle1.reload(14)
    print(reload_message)

    # Використання методу стрільби по три патрони
    print()
    burst_fire_message = custom_rifle1.burst_fire(1)
    print(burst_fire_message)

    # Використання методу автоматичної стрільби
    print()
    automatic_fire_message = custom_rifle1.automatic_fire(22)
    print(automatic_fire_message)

    # Використання методу одиночної стрільби
    print()
    single_fire_message = custom_rifle1.single_fire(10)
    print(single_fire_message)


if __name__ == "__main__":
    main()