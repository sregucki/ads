import requests
from typing import Any


def get_leetcode_solutions() -> dict[Any, Any]:
    body = '{ \
        matchedUser(username: "Seb732") { \
            username \
            submitStats: submitStatsGlobal { \
                acSubmissionNum { \
                    difficulty \
                    count \
                    submissions \
                } \
            } \
        } \
    }'
    response = requests.get(
        url="https://leetcode.com/graphql", json={"query": body}
    ).json()
    response_formatted = [
        list(entry.values())[:-1:]
        for entry in response["data"]["matchedUser"]["submitStats"]["acSubmissionNum"]
    ]
    return {entry[0]: entry[1] for entry in response_formatted}


def write_to_readme():
    with open("PROGRESS.md", "w+") as f:
        f.write(
            f"## Progress\n### Problems solved\n"
            f"|          | solved | total |\n"
            f"|----------|--------|-------|\n"
            f"| All      |   {get_leetcode_solutions()['All']}   |  2867 |\n"
            f"| Easy     |   {get_leetcode_solutions()['Easy']}   |\n"
            f"| Medium   |   {get_leetcode_solutions()['Medium']}   |\n"
            f"| Hard     |   {get_leetcode_solutions()['Hard']}    |\n"
        )


if __name__ == "__main__":
    write_to_readme()
