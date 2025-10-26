import json
import networkx as nx
import matplotlib.pyplot as plt

# Загружаем данные из JSON
with open("output_results.json") as f:
    data = json.load(f)

# Для каждого графа
for i, d in enumerate(data, start=1):
    G = nx.Graph()
    for e in d["mstEdges"]:
        u, v, w = e["u"], e["v"], e["w"]
        G.add_edge(u, v, weight=w)

    pos = nx.spring_layout(G, seed=42)
    weights = nx.get_edge_attributes(G, 'weight')

    nx.draw(G, pos, with_labels=True, node_color='lightblue', node_size=500, font_weight='bold')
    nx.draw_networkx_edge_labels(G, pos, edge_labels=weights)
    plt.title(f"Dataset {i}: MST (Cost={d['totalCost']:.2f})")
    plt.savefig(f"dataset{i}_MST.png")
    plt.clf()
