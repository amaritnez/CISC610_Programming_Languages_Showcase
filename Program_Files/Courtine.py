import aiohttp
import asyncio

async def fetch_url(url):
    response = await aiohttp.request('GET', url)
    return await response.read()

async def main():
    tasks = []
    for url in ['http://example.com', 'http://example.org', 'http://example.net']:
        tasks.append(asyncio.ensure_future(fetch_url(url)))
    responses = await asyncio.gather(*tasks)
    for response in responses:
        print(response)

loop = asyncio.get_event_loop()
loop.run_until_complete(main())

# import aiohttp
# import asyncio

# async def main():

#     async with aiohttp.ClientSession() as session:
#         async with session.get('http://python.org') as response:

#             print("Status:", response.status)
#             print("Content-type:", response.headers['content-type'])

#             html = await response.text()
#             print("Body:", html[:15], "...")

# loop = asyncio.get_event_loop()
# loop.run_until_complete(main())