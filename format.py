import json

# Nombre del archivo JSON que deseas modificar
archivo_json = 'data.json'

# Cargar el archivo JSON
with open(archivo_json, 'r', encoding='utf-8') as archivo:
    datos = json.load(archivo)

# Añadir el nuevo campo a cada objeto en la lista
for objeto in datos:
    objeto['exclusiveEquipment'] = 0

# Guardar los cambios en el archivo JSON
with open(archivo_json, 'w', encoding='utf-8') as archivo:
    json.dump(datos, archivo, indent=4, ensure_ascii=False)

print("Todos los objetos en '{}' han sido actualizados con 'exclusiveEquipment': 0.".format(archivo_json))
