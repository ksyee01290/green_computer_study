import csv
import io 

FIELDS = ['product','quantity','price']

def parse_s(raw):
    try:
        text = raw.decode('utf-8-sig')
        reader = csv.DictReader(io.StringIO(text), strict=True)

        if reader.fieldnames != FIELDS:
            raise ValueError('필수 열 순서: product,quantity,price')
        rows = []
        for number, source in enumerate(reader,2):
            if set(source) != set(FIELDS) or None in source.values():
                raise ValueError(f'{number}번째 레코드의 열을 확인하세요.')
            print(source)
            product = source['product'].strip()
            if not product or len(product) > 40:
                raise ValueError('상품명은 1~40글자입니다.')
            numeric = []
            for name in ('quantity', 'price'):
                value = source[name].strip()
                if not value.isascii() or not value.isdecimal():
                    raise ValueError("잘못된 숫자 거부")
                numeric.append(value)
            rows.append(dict(product=product, quantity=numeric[0], price=numeric[1]))
        return rows

    except UnicodeDecodeError as exc:
        raise ValueError('UTF-8 CSV를 사용하세요.') from exc
    except csv.Error as exc:
        raise ValueError('CSV 형식을 확인하세요.') from exc
