import requests, os
from tqdm import tqdm

for zoom in tqdm(range(0, 8), desc="Zoom level  "):
    os.makedirs(f"./Images/{zoom}", exist_ok=True)
    for x in tqdm(range(0, 2 ** zoom), desc='X Coordinate', leave=False):
        os.makedirs(f"./Images/{zoom}/{x}", exist_ok=True)
        for y in tqdm(range(0, 2 ** zoom), desc='Y Coordinate', leave=False):
            response = requests.get(f"https://static.xam.nu/dayz/maps/chernarusplus/1.23/satellite/{zoom}/{x}/{y}.webp")

            with open(f"./Images/{zoom}/{x}/{y}.jpeg", "wb") as f:
                f.write(response.content)