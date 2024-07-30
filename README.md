# capacitor-ir-transmitter

IR transmitter

## Install

```bash
npm install capacitor-ir-transmitter
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`transmitIR(...)`](#transmitir)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => any
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>any</code>

--------------------


### transmitIR(...)

```typescript
transmitIR(options: { frequency: number; address: number; command: number; }) => any
```

| Param         | Type                                                                  |
| ------------- | --------------------------------------------------------------------- |
| **`options`** | <code>{ frequency: number; address: number; command: number; }</code> |

**Returns:** <code>any</code>

--------------------

</docgen-api>
