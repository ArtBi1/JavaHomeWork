package HomeWork06;

public class Laptop {
    static int idCounter;
    int id;
    String brandName;       // Бренд
    String laptopType;      // Тип ноутбука
    String modelName;       // Модель ноутбука
    String screenSize;      // Размер экрана
    String cpu;             // Процессор
    String memory;          // ОЗУ ноутбука
    String storageType;     // Тип памяти
    String storage;         // Объем
    String os;              // ОС
    String cost;            // Цена

    public Laptop (String brandName, String laptopType, String modelName, String screenSize, String cpu, String memory, String storageType, String storage, String os, String cost){
        this.id = idCounter++;              // Увеличиваем счетчик и присваиваем уникальный идентификатор каждому ноутбуку
                                            // Устанавливаем значения:
        this.brandName = brandName;         // бренда
        this.laptopType = laptopType;       // типа ноутбука
        this.modelName = modelName;         // модели 
        this.screenSize = screenSize;       // размера экрана
        this.cpu = cpu;                     // процессор
        this.memory = memory;               // ОЗУ
        this.storageType = storageType;     // тип накопителя памяти
        this.storage = storage;             // объем накопителя
        this.os = os;                       // ОЗУ
        this.cost = cost;                   // цена
    }

    @Override
    public String toString(){
        // Возвращаем строковое представление ноутбука в определенном формате
        return id + ". " + laptopType + " " + brandName + " " + modelName + " (" + screenSize + "\"/" + cpu + "/" + memory + "GB/" + storageType + storage + "/" + os + " - " + cost + " руб.)\n";
    }

    public int getLaptopPrice(){ 
        return Integer.valueOf(cost); // Получаем цену ноутбука в виде целочисленного значения
    }
    
    public String getBrandParameter(){
        return brandName; // Получаем бренд ноутбука
    }

    public String getCPUParameter(){
        return cpu; // Получаем процессор
    }

    public String getMemoryParameter(){
        return memory; // Получаем ОЗУ
    }

    public String getStorageSizeParameter(){
        return storage; // Объем накопителя
    }

    public String getStorageTypeParameter(){
        return storageType; // Тип накопителя
    }

    public String getDisplaySizeParameter(){
        return screenSize; // Размер экрана
    }

    public String getOSParameter(){
        return os; // Получаем ОС
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (!(obj instanceof Laptop)){
            return false;
        }
        Laptop laptop = (Laptop) obj;
        // Проверка, равны ли все свойства объектов ноутбуков
        return brandName.equals(laptop.brandName) && cpu.equals(laptop.cpu) && memory.equals(laptop.memory) && storage.equals(laptop.storage) && screenSize.equals(laptop.screenSize) && laptopType.equals(laptop.laptopType);
    }
}
