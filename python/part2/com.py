import csv
import io 

FIELDS = ['id','product','quantity','price']

def parse_sales(raw):
    if len(raw) > 100_000:
        raise ValueError('파일은 100KB 이하로 준비하세요.')
    try:
        text = raw.decode('utf-8-sig')
        reader = csv.DictReader(io.StringIO(text), strict=True)

        if reader.fieldnames != FIELDS:
            raise ValueError('필수 열 순서: id,product,quantity,price')
        rows = []
        for number, source in enumerate(reader,2):
            #print(source)
            if len(rows) >= 1000:
                raise ValueError('데이터는 1000행 이하로 준비하세요.')
            if set(source) != set(FIELDS) or None in source.values():
                raise ValueError(f'{number}번째 레코드의 열을 확인하세요.')
            product = source['product'].strip()
            if not product or len(product) > 40:
                raise ValueError('상품명은 1~40글자입니다.')
            numeric = []
            for name in ('id','quantity', 'price'):
                value = source[name].strip()
                if not value.isascii() or not value.isdecimal():
                    raise ValueError(f'{name}에는 양의 정수를 입력하세요.')
                value = int(value)
                if not 1 <= value <= 1_000_000:
                    raise ValueError(f'{name}은 1~1000000 범위입니다.')
                numeric.append(value)
            rows.append(dict(id=numeric[0], product=product, quantity=numeric[1], price=numeric[2]))
        return rows

    except UnicodeDecodeError as exc:
        raise ValueError('UTF-8 CSV를 사용하세요.') from exc
    except csv.Error as exc:
        raise ValueError('CSV 형식을 확인하세요.') from exc

def summarize(rows):
    by_product = {}
    for row in rows:
        name = row['product']
        by_product[name] = by_product.get(name, 0) + row['quantity'] * row['price']

    return {
        'revenue':sum(by_product.values()),
        'quantity':sum(row['quantity'] for row in rows),
        'by_product':by_product
    }