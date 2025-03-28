def maxProfit(prices) -> int:
    buyPrice1 = float('inf')
    buyPrice2 = float('inf')

    profit1 = 0
    profit2 = 0
    sellPrice = 0
    sellPrice2 = 0
    calcTemp = 0

    for price in prices:
        if price < buyPrice1:
            buyPrice1 = price
        calcTemp = price - buyPrice1
        if profit1 < calcTemp:
            profit1 = calcTemp
        calcTemp = price - profit1
        if buyPrice2 > calcTemp:
            buyPrice2 = calcTemp
        calcTemp = price - buyPrice2
        if profit2 < calcTemp:
            profit2 = calcTemp
    return profit2

prices = [3,3,5,0,0,3,1,4]
maxProfit(prices)

